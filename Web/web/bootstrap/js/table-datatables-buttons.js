var TableDatatablesButtons = function () {

    var initTable1 = function () {
        var table = $('#sample_1');

        var oTable = table.dataTable({

            // Internationalisation. For more info refer to http://datatables.net/manual/i18n
            "language": {
                "aria": {
                    "sortAscending": ": activate to sort column ascending",
                    "sortDescending": ": activate to sort column descending"
                },
                "emptyTable": " 暂无数据！ ",
                "info": "显示 _START_ 到 _END_ ， 共 _TOTAL_ 条",
                "infoEmpty": " 没有符合条件记录！ ",
                "infoFiltered": " （总共 _MAX_ 条） ",
                "lengthMenu": "显示 _MENU_ 条 ",
                "search": "",
                "zeroRecords": " 没有查询到符合条件的记录！ "
            },
            


            // Or you can use remote translation file
            //"language": {
            //   url: '//cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Portuguese.json'
            //},

            buttons: [
                { extend: 'print', className: 'wph_print' , text: ''},//text可添加文字
                { extend: 'excel', className: 'wph_excel', text: ''}
            ],
            
                  


            // setup responsive extension: http://datatables.net/extensions/responsive/
            responsive: true,

            //"ordering": false, disable column ordering 
            //"paging": false, disable pagination

            "order": [
                [0, 'asc']
            ],
            
            "lengthMenu": [
                [10, 20, 30, 40, -1],
                [10, 20, 30, 40, "全部"] // change per page values here
            ],
            // set the initial value
            "pageLength": 10,

            "dom": "<'row' <'col-md-12'B>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal scrollable datatable

            // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
            // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js). 
            // So when dropdowns used the scrollable div should be removed. 
            //"dom": "<'row' <'col-md-12'T>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'f>r>t<'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>",
        });

        // handle datatable custom tools
        $('#sample_1_tools > li > a.tool-action').on('click', function() {
            var action = $(this).attr('data-action');
            oTable.DataTable().button(action).trigger();
        });
        
  	   $("#sample_1_previous").html("");
	   $("#sample_1_previous").html("<a href='javascript:;' ><</a>");
	   $("#sample_1_next").html("");
	   $("#sample_1_next").html("<a href='javascript:;'>></a>");
	   
        $("#sample_1_wrapper").click(function(){
        	dggg();
        	
        	
        	//加背景色
        	var className = $("#sample_1_paginate > span > a:first-child").attr("class").substring(24);
        	if( className == "phd_btn_page") {
        		$("#sample_1_paginate > span > a:first-child").addClass("phd_btn_page");
        		$("#sample_1_paginate > span > a:last-child").removeClass("phd_btn_page");
        	}else{
        		$("#sample_1_paginate > span > a:first-child").removeClass("phd_btn_page");
        		$("#sample_1_paginate > span > a:last-child").addClass("phd_btn_page");
        	}
        });
       $("#sample_1_filter > label > input").bind("input onpropertychange",function () {
    		dggg();
        });
       
        function dggg(){
	    	$("#sample_1_previous").html("");
	    	$("#sample_1_previous").html("<a href='javascript:;' ><</a>");
	    	$("#sample_1_next").html("");
	    	$("#sample_1_next").html("<a href='javascript:;' >></a>");
	    	
	    	//加背景色
	    	$("#sample_1_paginate > span > a:first-child").addClass("phd_btn_page");
	    	
        }
    };
   
    
      
    	//加背景色
    	window.onload=function(){
    		$("#sample_1_paginate > span > a:first-child").addClass("phd_btn_page");
    	};
   
    
    
    
    var initAjaxDatatables = function () {

        //init date pickers
//        $('.date-picker').datepicker({
//            rtl: App.isRTL(),
//            autoclose: true
//        });

        var grid = new Datatable();

        grid.init({
            src: $("#datatable_ajax"),
            onSuccess: function (grid, response) {
                // grid:        grid object
                // response:    json object of server side ajax response
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error  
            },
            onDataLoad: function(grid) {
                // execute some code on ajax data load
            },
            loadingMessage: 'Loading...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 

                // Uncomment below line("dom" parameter) to fix the dropdown overflow issue in the datatable cells. The default datatable layout
                // setup uses scrollable div(table-scrollable) with overflow:auto to enable vertical scroll(see: assets/global/scripts/datatable.js). 
                // So when dropdowns used the scrollable div should be removed. 
                
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r>t<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>",
                
                "bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.

                "lengthMenu": [
                    [10, 20, 50, 100, 150, -1],
                    [10, 20, 50, 100, 150, "全部"] // change per page values here
                ],
                "pageLength": 10, // default record count per page
                "ajax": {
                    "url": "../demo/table_ajax.php", // ajax source
                },
                "order": [
                    [1, "asc"]
                ],// set first column as a default sort by asc
            
                // Or you can use remote translation file
                //"language": {
                //   url: '//cdn.datatables.net/plug-ins/3cfcc339e89/i18n/Portuguese.json'
                //},

                buttons: [
                    { extend: 'print', className: 'btn default' },
                    { extend: 'copy', className: 'btn default' },
                    { extend: 'pdf', className: 'btn default' },
                    { extend: 'excel', className: 'btn default' },
                    { extend: 'csv', className: 'btn default' },
                    {
                        text: 'Reload',
                        className: 'btn default',
                        action: function ( e, dt, node, config ) {
                            dt.ajax.reload();
                            alert('Datatable reloaded!');
                        }
                    }
                ],

            }
        });

        // handle group actionsubmit button click
        grid.getTableWrapper().on('click', '.table-group-action-submit', function (e) {
            e.preventDefault();
            var action = $(".table-group-action-input", grid.getTableWrapper());
            if (action.val() != "" && grid.getSelectedRowsCount() > 0) {
                grid.setAjaxParam("customActionType", "group_action");
                grid.setAjaxParam("customActionName", action.val());
                grid.setAjaxParam("id", grid.getSelectedRows());
                grid.getDataTable().ajax.reload();
                grid.clearAjaxParams();
            } else if (action.val() == "") {
                App.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'Please select an action',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            } else if (grid.getSelectedRowsCount() === 0) {
                App.alert({
                    type: 'danger',
                    icon: 'warning',
                    message: 'No record selected',
                    container: grid.getTableWrapper(),
                    place: 'prepend'
                });
            }
        });

        //grid.setAjaxParam("customActionType", "group_action");
        //grid.getDataTable().ajax.reload();
        //grid.clearAjaxParams();

        // handle datatable custom tools
        $('#datatable_ajax_tools > li > a.tool-action').on('click', function() {
            var action = $(this).attr('data-action');
            grid.getDataTable().button(action).trigger();
        });
    }

    return {

        //main function to initiate the module
        init: function () {

            if (!jQuery().dataTable) {
                return;
            }

            initTable1();
            initAjaxDatatables();
        }

    };

}();

jQuery(document).ready(function() {
    TableDatatablesButtons.init();
});