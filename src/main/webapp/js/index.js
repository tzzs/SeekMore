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
                    "            <a href=\"../images/img_" + d + ".jpg\" class=\"image-popup fh5co-board-img\"\n" +
                    "               title=\"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?\"><img\n" +
                    "                    src=\"../images/img_" + d + ".jpg\" alt=\"Free HTML5 Bootstrap template\"></a>\n" +
                    "            <div class=\"fh5co-desc\" style=\"float:none;word-wrap:break-word\"><a href=\"\">" + data[d].qContent +
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


function search(e) {
    e.preventDefault();
    var content = $("#search-content").val();
    $.ajax({
        url: "",
        type: "json",
        async: false,
        data: {"content": content},
        success: function (data) {
            document.getElementById("items").innerHTML = "";
            var html = "<div class=\"item\">\n" +
                "          <div class=\"animate-box\">\n" +
                "            <a href=\"../images/img_1.jpg\" class=\"image-popup fh5co-board-img\"\n" +
                "               title=\"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo, eos?\"><img\n" +
                "                    src=\"../images/img_1.jpg\" alt=\"Free HTML5 Bootstrap template\"></a>\n" +
                "            <div class=\"fh5co-desc\"><a href=\"\">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo,\n" +
                "              eos?</a></div>\n" +
                "          </div>\n" +
                "        </div>";
            document.getElementById("items").insertAdjacentHTML("beforeend", html);
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