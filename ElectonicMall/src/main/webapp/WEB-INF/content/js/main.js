jQuery(document).ready(function($){
	var tabItems = $('.cd-tabs-navigation a'),
		tabContentWrapper = $('.cd-tabs-content');

	tabItems.on('click', function(event){
		event.preventDefault();
		var selectedItem = $(this);
		if( !selectedItem.hasClass('selected') ) {
			var selectedTab = selectedItem.data('content'),
				selectedContent = tabContentWrapper.find('li[data-content="'+selectedTab+'"]'),
				slectedContentHeight = selectedContent.innerHeight();
			
			tabItems.removeClass('selected');
			selectedItem.addClass('selected');
			selectedContent.addClass('selected').siblings('li').removeClass('selected');
			tabContentWrapper.animate({
				'height': slectedContentHeight
			}, 200);
		}
	});

	checkScrolling($('.cd-tabs nav'));
	$(window).on('resize', function(){
		checkScrolling($('.cd-tabs nav'));
		tabContentWrapper.css('height', 'auto');
	});
	$('.cd-tabs nav').on('scroll', function(){ 
		checkScrolling($(this));
	});

	function checkScrolling(tabs){
		var totalTabWidth = parseInt(tabs.children('.cd-tabs-navigation').width()),
		 	tabsViewport = parseInt(tabs.width());
		if( tabs.scrollLeft() >= totalTabWidth - tabsViewport) {
			tabs.parent('.cd-tabs').addClass('is-ended');
		} else {
			tabs.parent('.cd-tabs').removeClass('is-ended');
		}
	}
});

/**
 * 添加商品到购物车
 * */
function addCommodityToCart(cid) {
    $.ajax(
        {
            url:"/cart",
            type:"post",
            dataType:"json",
			data:
				{commodityId:cid,
					amount:1
				},
            success:function (res) {
                if (res.returnCode == 1){
                    price = res.data;
                    addCartItemAmount(1);
                    addCartTotal(price);
                }
            }
        }
    )
}

/**
 * 清空购物车
 * */
function clearCart() {
    $.ajax(
        {
            url:"/cart/clear",
            type:"get",
            dataType:"json",
            success:function (res) {
                if (res.returnCode == 1){
                    clearCartContent();
                }
            }
        }
    );
}

/**
 * 从购物车移除商品
 * */
function removeCommodityFromCart(cid) {
    $.ajax(
        {
            url:"/cart/" + cid,
            type:"delete",
            dataType:"json",
            success:function (res) {
                if (res.returnCode == 1){
                    $('#' + cid + '_div').
                    slideUp(300, function(){
                        $(this).remove()
                    });
                }
            }
        }
    )
}

/**
 * 增加购物车商品数量的值
 * @param amount
 * 			需要增加的值
 * */
function addCartItemAmount(amount) {
    var nowAmount = $('#simpleCart_quantity').text();
    if (isRealNum(nowAmount)){
        $('#simpleCart_quantity').text(nowAmount * 1 + amount);
    }
    else {
        $('#simpleCart_quantity').text(amount);
	}
}

/**
 * 增加购物车商品总价格的值
 * @param price
 * 			需要增加的值
 * */
function addCartTotal(price) {
    var nowTotal = $('#simpleCart_total').text();
    if (isRealNum(nowTotal)){
        $('#simpleCart_total').text(nowTotal * 1.0 + price);
    }
    else {
        $('#simpleCart_total').text(price);
	}
}

/**
 * 判断一个字符串是否为数字
 * @param val
 * 			需要判断的字符串
 * @return
 * 			若为数字返回true
 * */
function isRealNum(val){
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if(val === "" || val ==null){
        return false;
    }
    if(!isNaN(val)){
        return true;
    }else{
        return false;
    }
}

/**
 * 清空购物车内容
 * */
function clearCartContent() {
    $('#simpleCart_total').text("");
    $('#simpleCart_quantity').text("购物车为空");
}

/**
 * 提交搜索表单
 * @param 搜索页码
 * */
function searchForPage(pageNum) {
    $("[name='nowPage']").attr('value', pageNum);
    $("#searchForm").submit();
}