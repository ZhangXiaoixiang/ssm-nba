layui.config({
    version: '1545041465480' //为了更新 js 缓存，可忽略
});

$(document).ready(function () {
    $(function () {
        layuiInit()
    });
});


function layuiInit() {
    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function () {
        var laydate = layui.laydate //日期
            , laypage = layui.laypage //分页
            , layer = layui.layer //弹层
            , table = layui.table //表格
            , carousel = layui.carousel //轮播
            , upload = layui.upload //上传
            , element = layui.element //元素操作
            , slider = layui.slider //滑块


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , height: 500
            , url: 'http://localhost:8080/sys/data/PlayerInfo/getPlayerInfoByCondition' //数据接口
            , title: '球员场均得分排行'
            , page: true //开启分页
            // , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            // , totalRow: true //开启合计行
            , limits: [5, 10, 20, 30]
            , request: {
                pageName: 'startPage' //页码的参数名称，默认：page
                , limitName: 'pageSize' //每页数据量的参数名，默认：limit
            }


            , cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: '后台编号', sort: true, fixed: 'left', totalRowText: '合计：'}
                , {field: 'playerId', title: '球员编号',}
                , {field: 'teamId', title: '球队名称',}
                , {field: 'nameEn', title: '球员英文名', width: 190, sort: true, totalRow: true}
                , {field: 'nameCh', title: '球员中文名', width: 180, sort: true}
                , {field: 'playerRole', title: '角色', width: 180, sort: true, totalRow: true}
                , {field: 'height', title: '身高', width: 180, sort: true, totalRow: true}
                , {field: 'weight', title: '体重', width: 180, sort: true, totalRow: true}
                , {field: 'bollYear', title: 'NBA球龄', sort: true, totalRow: true}
                , {field: 'nationality', title: '国籍', width: 180, sort: true, totalRow: true}
                , {fixed: 'right', title: '操作', width: 165, align: 'center', toolbar: '#barDemo'}

            ]]

        });


        // 监听头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id)
                , data = checkStatus.data; //获取选中的数据
            switch (obj.event) {
                case 'add':
                    layer.msg('添加');
                    break;
                case 'update':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else if (data.length > 1) {
                        layer.msg('只能同时编辑一个');
                    } else {
                        layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                    }
                    break;
                case 'delete':
                    if (data.length === 0) {
                        layer.msg('请选择一行');
                    } else {
                        layer.msg('删除');
                    }
                    break;
            }
            ;
        });


        // 监听行工具事件
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                // layer.msg('查看操作');
                var $ = layui.$ //由于layer弹层依赖jQuery，所以可以直接得到
                //墨绿深蓝风
                $.ajax({
                    url: 'http://localhost:8080/sys/data/PlayerInfo/getInfo/' + data.id,
                    success: function (data) {
                        if (data.result == 'success') {
                            layer.msg("查看ajax发送成功!")

                        }
                    }

                });
                layer.alert('球员姓名: ' + data.nameCh + "<br>球队名称: " + data.teamId + "<br>球员角色: " + data.playerRole + "<br>身高: " + data.height
                    + "<br>体重: " + data.weight + "<br>球龄: " + data.bollYear + "<br>球员国籍: " + data.nationality,
                    {
                        skin: 'layui-layer-molv' //样式类名
                        , closeBtn: 0
                    });


            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么' + data.id, function (index) {

                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                    var $ = layui.$; //由于layer弹层依赖jQuery，所以可以直接得到
                    $.ajax({
                        //rest风格删除(就是拼接而已)
                        url: 'http://localhost:8080/sys/data/PlayerInfo/delete/' + data.id,
                        // type: "GET",
                        data: {"sum": data.id},
                        dataType: "json",
                        success: function (data) {
                            if (data.delete == "ok") {
                                //提示说明删除成功
                                //  location.reload();


                                //    刷新,因为总数需要刷新
                                layer.alert('删除成功!', {icon: 6});
                                layuiInit();


                            } else {
                                layer.alert('删除失败!', {icon: 5});
                            }


                        }
                    });
                    table.render({
                        limits: [15, 10, 20, 70]
                    })


                });

            } else if (layEvent === 'edit') {
                //下面是传统方式的页面跳转
                 window.location.href = "http://localhost:8080/sys/page/PlayerInfo/goUpdate?id=" + data.id



            }
        });
//    ----------------------------


    });
}



