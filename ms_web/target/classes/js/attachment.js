$(
    function ()
    {
        // 创建一个上传参数变量
        var uploadOption =
            {
                action: "projectUpload",    // 提交目标

                name: "file",            // 服务端接收的名称

                dataType: "json",

                autoSubmit: true,        // 是否自动提交

                // 开始上传文件
                onSubmit: function (file, extension)
                {
                    this.setData({project_id_class: $("#attachment_id").val()});
                },

                // 上传完成之后
                onComplete: function (file, response)
                {
                    attachment_list($("#attachment_id").val());
                }
            };

        // 把上传参数变量放到上传函数中
        new AjaxUpload("#upload_button", uploadOption);

        //删除上传列表中的选中文件
        $("#delBtn").click
        (
            function ()
            {
                if (confirm("请确认是否要删除这些节点"))
                {
                    var checkBoxes = $("#content1 :checkbox");

                    var checkBox = null;

                    var idList = [];

                    $.each
                    (
                        checkBoxes,

                        function (i)
                        {
                            checkBox = $(checkBoxes[i]);

                            if (checkBox.prop("checked"))
                            {
                                idList.push(checkBox.parent().parent().data("id"));
                            }
                        }
                    );

                    ajax4Json
                    (
                        "delBuildAttachs",

                        function (data)
                        {
                            loadBuildProjectList($("#buildid").val());
                        },

                        {idList: idList}
                    );
                }
            }
        );

        //确认送审
        $("#subBtn").click
        (
            function ()
            {
                var id = $("#buildid").val();

                ajax4Json
                (
                    "sendBuild",

                    function (data)
                    {
                        window.location.href = "getBuild_projects";
                    },

                    {buildid: id, remark: $("#remark").val()}
                );
            }
        );

        //显示上传列表
        $(".attachment_button").click
        (
            function ()
            {
                var id = $(this).parent().prevAll(".project_id_class").text();

                $("#attachment_id").val(id);

                attachment_list(id);//查附件表
            }
        );

        // 显示送审列表
        $(".send").click
        (
            function ()
            {
                $("#attachment_id").val($(this).parent().prevAll(".project_id_class").text());
            }
        );
    }
);



/**
 * ajax获取json数据
 */
function ajax4Json(url,datas)
{
    $.ajax({
        type : "POST",

        url : url,

        data : datas,

        dataType : "JSON",

        async : false,

        success : function(data)
        {
          console.success(data);
        },

        error : function()
        {
            console.error("ajax error!");
        }
    });
}



// 上传列表函数
function attachment_list(id)
{
    ajax4Json
    (
        "attachment_list",

        function (data)
        {
            var thead = $("#content1").children(":first");

            $("#content1").empty();

            $("#content1").append(thead);

            var attachList = data["build_project_attachList"];


            var keyList = ["fileName"];

            $.each
            (
                attachList,

                function(i)
                {
                    var attach = attachList[i];

                    var tr = createDataRow(attach, keyList, true)
                        .append
                        (
                            "<th><a class='download' style='color:#666; cursor:pointer;'>下载</a></th>"
                        );

                    $("#content1").append(tr);
                }
            );

            $(".download").click
            (
                function ()
                {
                    download("builddownload", {project_id_class: $(this).parent().parent().data("id")});
                }
            );

        },

        {project_id: id}
    );
}