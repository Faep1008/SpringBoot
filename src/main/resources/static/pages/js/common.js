if (!window.faep) {
    window.faep = {};
}
jQuery.extend(faep, (function (win, $) {
    return {
        execute: function (actionName, params, callback) {
            if (params == null) {
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

        // 判断字符串是否为空
        isEmpty: function (value) {
            //正则表达式用于判斷字符串是否全部由空格或换行符组成
            var reg = /^\s*$/
            //返回值为true表示不是空字符串
            return (value == null || value == undefined || reg.test(value));
        },
        // 校验手机号格式
        isPhoneNum: function (phoneNum){
            var myreg = /^[1][3,4,5,6,7,8,9][0-9]{9}$/;
            return myreg.test(phoneNum);
        },
        // 校验Email格式
        isEmail: function (email){
            var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
            return myreg.test(email);
        },
        // 校验日期格式
        isDate: function (date){
            var myreg = /^(\d{4})-(\d{2})-(\d{2})$/;
            return myreg.test(date);
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