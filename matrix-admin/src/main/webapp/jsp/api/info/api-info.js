/**
 * api信息树相关功能
 */
var apiInfo = {
		path:null,
		
		/**
		 * 实例化对象
		 */
		launch:function(path_){
			apiInfo.path = path_ + 'apicenter/';                     
			return apiInfo;
		},

        /**
         * 初始化树
         */
		apiTreeInit: function(){
        	$("#api-tree li").remove();
        	$($("#tree-node-edit")[0].childNodes).remove();
        	var type_ = 'post';
            var url_ = 'ajax_api_info_list.do';
            var data_ = null;   
            var obj = JSON.parse(ajaxs.sendAjax(type_ , url_ , data_));  
            if(obj.status == 'success'){
                var zNodes = obj.list;
                $.fn.zTree.init($("#api-tree") , setting_nav , zNodes);
                $("#callbackTrigger").bind("change", {}, setting_.setTrigger);
            }
        }, 


}

/**
 * 定义树的基本属性
 */
var setting_ = {
        view: {
            addHoverDom: false,
            removeHoverDom: false,
            selectedMulti: false    // 不允许同时选中多个节点
        },
        check:{
        	enable:true
        }, 
        edit: {
            drag: {
                autoExpandTrigger: true, // 拖拽时父节点自动展开是否触发 callback.onExpand 事件回调函数
                prev: false, //允许移动到目标节点前面 即可以将同层最后一个节点放到同层的第一个。 
                next: false,  // 设置是否允许移动到同层节点的最后一个节点的后面 从而使被移动的节点成为最后一个节点 
                inner: false // 拖拽到目标节点时 设置是否允许成为目标节点的子节点。
            },
            enable: false,  // 设置 zTree 是否处于编辑状态默认false|初始化后需要改变编辑状态请使用 zTreeObj.setEditable() 方法
            showRemoveBtn: false, // 树形控件显示删除按钮
            showRenameBtn: false  // 树形控件显示编辑按钮
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: 0
            }
        },
        callback: {
            beforeDrag: false,         // 捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作 |默认值：null
            beforeDrop: false,         // 捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作 |默认值：null
            beforeDragOpen: false,  // 获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作 |默认值：null
            onDrag: false,                     // 捕获节点被拖拽的事件回调函数 |默认值：null
            onDrop: false,                     // 捕获节点拖拽操作结束的事件回调函数 |默认值：null
            onExpand: false,           // 捕获节点被展开的事件回调函数 |默认值：null
            onClick: false,
            beforeRemove: false,       // 捕获删除之前的数据 
            beforeCheck: surfunc.beforeCheck,    // 捕获 勾选 或 取消勾选 之前的事件回调函数
            onCheck : surfunc.onCheck
        },
        setTrigger:function(){
            var zTree = $.fn.zTree.getZTreeObj("api-tree");
            zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
        }
    };










