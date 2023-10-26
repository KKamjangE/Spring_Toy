/**
 * 로그인
 */
const login = () => {
    const userId = document.getElementById("sign-in-id").value;
    const password = document.getElementById("sign-in-password").value;
    $.ajax({
        url: `${BASE_URL}/sign/in`,
        type: "post",
        data: {
            userId,
            password
        },
        success: (response) => {
            console.log(response);
        }
    })
}

const signInBtn = document.getElementById("sign-in-btn");
signInBtn.addEventListener("click", login);

/**
 * 회원 가입
 */
const join = () => {
    const userIdElement = document.getElementById("sign-up-id");
    const passwordElement = document.getElementById("sign-up-password");
    const passwordCheckElement = document.getElementById("sign-up-password-check");
    const userNameElement = document.getElementById("user-name");

    if(userIdElement.value === "") {
        alert("아이디를 입력해주세요.");
        userIdElement.focus();
        return;
    } else if(passwordElement.value === "") {
        alert("비밀번호를 입력해주세요.");
        passwordElement.focus();
        return;
    } else if(userNameElement.value === "") {
        alert("이름을 입력해주세요.");
        userNameElement.focus();
        return;
    }

    if(passwordCheckElement.value === passwordElement.value) {
        $.ajax({
            url: `${BASE_URL}/sign/up`,
            type: "post",
            data: {
                userId: userIdElement.value,
                password: passwordElement.value,
                name: userNameElement.value
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