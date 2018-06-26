function reset() {
    $("#form").reset();
}

function login() {

    $.ajax({
        type: "post",
        url: "",
        data: $("form").serialize(),
        async: false,
        success: function (data) {
            if (data.msg === true) {
                //
            } else {
                alert();
                reset();
            }
        }
    })
}

function register() {
    $.ajax({
        type: "post",
        url: "",
        data: $("form").serialize(),
        async: false,
        success: function (data) {
            if (data.msg === true) {
                //
            } else {
                alert();
                reset();
            }
        }
    })
}

function checkAccount() {
    const account = $("#rAccount").val();
    if (account.length < 6) {
        $("#info").text("账号长度不满足6位");
    } else {
        $("#info").text("");
        $("#login").attr("disable", false);
    }
}


function checkRPwd() {
    const rpwd = $("#rPassword").val();
    if (rpwd == "") {
        $("#info").text("密码不可为空");
        $("#login").attr("disable", true);
    } else {
        $("#info").text("");
        $("#login").attr("disable", false);
    }
}

function checkRePwd() {
    const rpwd = $("#rPassword").val();
    const repwd = $("#rePassword").val();
    if (rpwd != repwd) {
        $("#info").text("输入密码不相同");
        $("#login").attr("disable", true);
    } else {
        $("#info").text("");
        $("#login").attr("disable", false);
    }
}