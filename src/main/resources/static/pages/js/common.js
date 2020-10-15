if (!window.faep) {
    window.faep = {};
}
jQuery.extend(faep, (function (win, $) {
    return {
        execute: function (actionName, params, callback) {
            if(params == null){
                params = {};
            }
            var list = params;
            $.ajax({
                //请求方式
                type: "POST",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url: "http://" + window.location.host + "/" + actionName,
                //数据，json字符串
                data: JSON.stringify(list),
                //请求成功
                success: function (result) {
                    callback(result);
                },
                //请求失败，包含具体的错误信息
                error: function (e) {
                    console.log(e.status);
                    console.log(e.responseText);
                    alert(e.status + ":" + e.statusText + ":" + e.responseText);
                }
            });
        },

        setParams: function (params) {
            var jsonData = {};
            params.forEach(function (e) {
                jsonData[e] = $("#" + e).val();
            });
            return jsonData;
        },

        alert: function (tip) {
            $("#tipModal").remove();
            var html = "<div class=\"modal fade\" id=\"tipModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                "    <div class=\"modal-dialog\">\n" +
                "        <div class=\"modal-content\">\n" +
                "            <div class=\"modal-header\">\n" +
                "                <h5 class=\"modal-title\" id=\"exampleModalLabel\">提示</h5>\n" +
                "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                    <span aria-hidden=\"true\">&times;</span>\n" +
                "                </button>\n" +
                "            </div>\n" +
                "            <div class=\"modal-body\">\n" +
                tip +
                "            </div>\n" +
                "            <div class=\"modal-footer\">\n" +
                "                <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">关闭</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>";

            $("body").append(html);
            $('#tipModal').modal('show');
        }
    }
}(this, jQuery)));