function load() {
    $.ajax({
        url:"",
        type:"post",
        async:false,
        success:function (data) {

            for (var i = 0; i < data.length; i++) {
                var d = data[i];
                var html = "div class=\"row\">\n" +
                    "                                <div class=\"col-xs-2 \">\n" +
                    "                                    "+d.id+"\n" +
                    "                                </div>\n" +
                    "                                <div class=\"col-xs-2\">\n" +
                    "                                    "+d.userName+"\n" +
                    "                                </div>\n" +
                    "                                <div class=\"col-xs-2\">\n" +
                    "                                    "+d.userSex+"\n" +
                    "                                </div>\n" +
                    "                                <div class=\"col-xs-2\">\n" +
                    "                                    "+d.userPhone+"\n" +
                    "                                </div>\n" +
                    "                                <div class=\"col-xs-2\">\n" +
                    "                                    "+d.userEmail+"\n" +
                    "                                </div>\n" +
                    "                                <div class=\"col-xs-2\">\n" +
                    "                                    <button class=\"btn btn-danger btn-xs\" data-toggle=\"modal\" data-target=\"#deleteUser\">删除</button>\n" +
                    "                                </div>\n" +
                    "                            </div>";

                $("#userTable").insertAdjacentHTML("beforeend",html);
            }
        }
    })
}

function delet(){

}


window.onload = load;