
$(document).ready(function () {

    if ($("#ddlgame").length > 0) {

        $("#ddlgame").empty();
        $("#ddlgameserver").empty();

        $("#ddlgame").append("<option value='0'>请选择</option>");
        $("#ddlgameserver").append("<option value='0'>请选择</option>");

        $.ajax({
            url: "/cs-web/game/getAllGame.do",
            type: "GET",
            dataType: "json",
            success: function (d) {
                $.each(d, function (index, item) {

                    if ($("#hidGameId").val() == item.code) {
                        $("#ddlgame").append("<option value='" + item.code + "' selected='selected'>" + item.name + "</option>");
                    }
                    else {
                        $("#ddlgame").append("<option value='" + item.code + "'>" + item.name + "</option>");
                    }
                });

                loadgameserver('false');
            }
        });

        $("#ddlgame").change(loadgameserver);
    }
});

//根据value设置dropdownlist选中项
function setDropDownList(ddl, value) {

    ddl.val(value);

}

//根据游戏加载服务器
function loadgameserver(flag) {

    var gameid = $("#ddlgame").val();
 
    $("#ddlgameserver").empty();
    $("#ddlgameserver").append("<option value='0'>请选择</option>");

    if (gameid == "0") {

        return;
    }

    if ($("#ddlgameserver").length > 0) {
        $.getJSON("/cs-web/server/getServerList.do?gameId=" + gameid + "&format=json&callback=loadgame", function loadgame(o) {
            if (o == null) {
                $("#ddlgameserver").empty();
                $("#ddlgameserver").append("<option value='0'>请选择</option>");
            } else {
                $.each(o, function (index, item) {
                    if (flag == 'false' && $("#hidServerId").val() == item.code) {
                        $("#ddlgameserver").append("<option value='" + item.code + "' selected='selected'>" + item.name + "</option>");
                    }
                    else {
                        $("#ddlgameserver").append("<option value='" + item.code + "'>" + item.name + "</option>");
                    }
                });
            }

        });
    }
}