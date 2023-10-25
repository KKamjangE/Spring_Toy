const login = () => {
    const _id = document.getElementById("sign-in-id").value;
    const password = document.getElementById("sign-in-password").value;
    $.ajax({
        url: `${BASE_URL}/sign/in`,
        type: "post",
        data: {
            _id,
            password
        },
        success: (response) => {
            console.log(response);
        }
    })
}
const signInBtn = document.getElementById("sign-in-btn");
signInBtn.addEventListener("click", login);

const join = () => {
    const userId = document.getElementById("sign-up-id");
    const password = document.getElementById("sign-up-password");
    const passwordCheck = document.getElementById("sign-up-password-check");
    const userName = document.getElementById("user-name");

    if(userId.value === "") {
        alert("아이디를 입력해주세요.");
        userId.focus();
        return;
    } else if(password.value === "") {
        alert("비밀번호를 입력해주세요.");
        password.focus();
        return;
    } else if(userName.value === "") {
        alert("이름을 입력해주세요.");
        userName.focus();
        return;
    }

    if(passwordCheck.value === password.value) {
        $.ajax({
            url: `${BASE_URL}/sign/up`,
            type: "post",
            data: {
                userId: userId.value,
                password: password.value,
                name: userName.value
            },
            success: (response) => {
                console.log(response);

                if(response.statusCode === 200) {
                    alert("회원가입 성공.");
                    window.location.assign("/auth/login");
                } else if(response.statusCode === 409) {
                    alert("이미 존재하는 아이디입니다.");
                }
            },
        });
    } else {
       alert("비밀번호가 일치하지 않습니다.");
    }
}
const signUpBtn = document.getElementById("sign-up-btn");
signUpBtn.addEventListener("click", join);