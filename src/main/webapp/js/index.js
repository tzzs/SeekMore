function load() {
    $.ajax({
        url: "/questions/findAll",
        type: "post",
        async: false,
        success: function (data) {
            console.log(data.length);
            for (var d = 0; d < data.length; d++) {
                console.log(data[d].qContent);

                var index = d % 4 + 1;//列数

                var html = "<div class=\"item\">\n" +
                    "          <div class=\"animate-box  bounceIn animated\">\n" +
                    "            <a href=\"/questions/find?id=" + data[d].id + "\" class=\"image-popup fh5co-board-img\"\n" +
                    "               title=\"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?\"><img\n" +
                    "                    src=\"../images/img_" + (d + 1) + ".jpg\" alt=\"No picture\"></a>\n" +
                    "            <div class=\"fh5co-desc\" style=\"float:none;word-wrap:break-word\"><a href=\"\">" + data[d].qTitle +
                    "              </a></div>\n" +
                    "          </div>\n" +
                    "        </div>";
                console.log($("#fh5co-board").children());
                console.log(html);

                $("#fh5co-board").children()[3 - (d % 4)].insertAdjacentHTML("beforeend", html);
            }
        }
    })
}


function search() {
    var qTitle = $("#search-title").val();
    console.log(qTitle);
    $.ajax({
        url: "/questions/findByLike",
        type: "post",
        async: false,
        data: {"qTitle": qTitle},
        success: function (data) {
            var c = $("#fh5co-board").children();

            for (var i = 0; i < c.length; i++) {
                console.log(c[i]);
                c[i].innerHTML = "";
            }
            for (var d = 0; d < data.length; d++) {
                console.log(data[d].qContent);

                var index = d % 4 + 1;//列数

                var html = "<div class=\"item\">\n" +
                    "          <div class=\"animate-box  bounceIn animated\">\n" +
                    "            <a href=\"/questions/find?id=" + data[d].id + "\" class=\"image-popup fh5co-board-img\"\n" +
                    "               title=\"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?\"><img\n" +
                    "                    src=\"../images/img_" + (d + 1) + ".jpg\" alt=\"No picture\"></a>\n" +
                    "            <div class=\"fh5co-desc\" style=\"float:none;word-wrap:break-word\"><a href=\"\">" + data[d].qTitle +
                    "              </a></div>\n" +
                    "          </div>\n" +
                    "        </div>";
                console.log($("#fh5co-board").children());
                console.log(html);

                $("#fh5co-board").children()[3 - (d % 4)].insertAdjacentHTML("beforeend", html);
            }
        }
    })
}

function close_box() {
    $(".box-pwd").css({
        "display": "none"
    });

    $(".box-shadow").css({
        "display": "none"
    });

    /* 清空残留数据 */
    $("#id").val("");
    $("#title").val("");
    $("#topic").val("");
    $("#des").val("");
    $(".submit").removeClass("add_submit").removeClass("update_submit");
    $("#form").attr("action", "#");
}


function addQuestion() {
    console.log("123");
    if ($(".box-pwd").css("display") === 'none') {

        $(".box-pwd").css({
            "display": "block"
        });

        $("#submit").attr({
            "value": "提交"
        });

        $("#submit").addClass("update_submit");

        /* 阴影 */
        $(".box-shadow").css({
            "display": "block"
        });

        //修改form action

        $("#form").attr({"action": "#"});

        $(".submit").click(function (e) {
            e.preventDefault();
            var title = document.getElementById("title").value;
            var content = document.getElementById("des").value;
            $.ajax({
                url: "/questions/addQuestion",
                type: "post",
                dataType: "json",
                async: false,
                data: {"title": title, "content": content},
                success: function (data) {
                    console.log(data.msg);
                    alert(data.msg);
                }
            });
        });
    }
}


window.onload = load;