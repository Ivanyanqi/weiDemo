
function arrayPage(pages,total,currentPage) {
    //init
    var totalPage = pages;
    var totalRecords = total;
    var pageNo = currentPage;

    //生成分页
    jpager.generPageHtml({
        pno : pageNo,
        //总页码
        total : totalPage,
        //总数据条数
        totalRecords : totalRecords,
        //链接前部
        hrefFormer : "/userList",
        //链接尾部
        hrefLatter : '',
        getLink : function(n){
         	//alert(n);
        	return this.hrefFormer + this.hrefLatter + "?&currentPage="+n;
        },
        /* 		lang : {
         firstPageText : '|<',
         lastPageText : '>|',
         prePageText : '<',
         nextPageText : '>',
         totalPageBeforeText : '共',
         totalPageAfterText : '页',
         totalRecordsAfterText : '条数据',
         gopageBeforeText : '转到',
         gopageButtonOkText : '确定',
         gopageAfterText : '页',
         buttonTipBeforeText : '第',
         buttonTipAfterText : '页'
         } */
        //,
        mode : 'click',//默认值是link，可选link或者click
    /*    click : function(n){
            //alert(n);
            jQuery.ajax({
                type : 'GET',
                url  : jsonServer + 'FSCH002Controller/search.jsonp',
                data : {'keywords':keyword,'currentPage':n,'queryType':type},
                dataType : 'json',
                success:function (data) {
                    console.log(data['searchResults'].length);
                    var html = template('projectTpl', data);
                    if(type == 'all'){
                        jQuery("#tab1").html(html);
                    }else if(type == 'project'){
                        jQuery("#tab2").html(html);
                    }else if(type == 'sample'){
                        jQuery("#tab3").html(html);
                    }else if(type == 'experiment'){
                        jQuery("#tab4").html(html);
                    }else if(type == 'run'){
                        jQuery("#tab5").html(html);
                    }
                },
                error:function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR.readyState + "," + jqXHR.status + "," + textStatus + "," + errorThrown);
                }
            });
            this.selectPage(n);  //切换页码
        }*/
    });   // true 表示每次都重新生成
}

