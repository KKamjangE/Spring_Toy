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
    const _id = document.getElementById("sign-up-id").value;
    const password = document.getElementById("sign-up-password").value;
    const passwordCheck = document.getElementById("sign-up-password-check").value;
    const userName = document.getElementById("user-name").value;

    if(passwordCheck === password) {
        $.ajax({
            url: `${BASE_URL}/sign/up`,
            type: "post",
            data: {
                userId: _id,
                password: password,
                name: userName
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