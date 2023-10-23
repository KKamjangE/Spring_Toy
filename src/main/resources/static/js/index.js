const btn = document.getElementById("submitTest");
btn.addEventListener("click", () => {
    $.ajax({
        url: `${BASE_URL}/search/center`,
        type: "post",
        data: {
            id: 1,
            page: 1,
            perPage: 10,
        },
        success: (data) => {
            console.log(data);
        }
    })
});