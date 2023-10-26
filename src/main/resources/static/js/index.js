/**
 * 공공데이터 가져오기
 */
const searchCenters = () => {
    const page = document.getElementById("page").value;
    const perPage = document.getElementById("perPage").value;

    $.ajax({
        url: `https://api.odcloud.kr/api/15077586/v1/centers?page=${page}&perPage=${perPage}&serviceKey=SS7FlL5U37rkJ8U0Sunubf8Q59FznevY5CA7Si7iFrxDKsxLk6fGumQj8aOctOezGCl5hOsVw8j2%2Becj3KKgjQ%3D%3D`,
        type: "get",
        success: (data) => {
            console.log(data);
            document.getElementById("search-center-result").innerHTML = centerResultHtml(data.data);
        }
    });
}

const searchCenterBtn = document.getElementById("search-centers");
searchCenterBtn.addEventListener("click", searchCenters);

/**
 * 공공 데이터 저장
 * @param thisBtn html 태그의 this
 */
function saveCenter(thisBtn) {
    const idx = thisBtn.dataset.idx;
    const title = document.getElementById(`center-${idx}-title`).textContent;
    const org = document.getElementById(`center-${idx}-org`) ? document.getElementById(`center-${idx}-org`).textContent : "";
    const facility = document.getElementById(`center-${idx}-facility`).textContent;
    const address = document.getElementById(`center-${idx}-address`).textContent;

    return;

    $.ajax({
        url: `${BASE_URL}`,
        type: "post",
        body: {
            title,
            org,
            facility,
            address
        },
        success: (data) => {
            console.log(data);
        }
    });
}

/**
 * 공공 데이터로 html 생성
 * @param data 공공 데이터
 * @returns {string} // html
 */
const centerResultHtml = (data) => {
    let html = "";

    data.forEach((center) => {
        html += `
            <div class="card shadow">
                <div class="card-body">
                    <h5 id="center-${center.id}-title" class="card-title">${center.centerName}</h5>
                    <div class="d-flex justify-content-between align-items-end">
                        <div class="d-flex flex-column">
                            ${center.org && `<p id="center-${center.id}-org">${center.org}</p>`}
                            <span id="center-${center.id}-facility">${center.facilityName}</span>
                            <span id="center-${center.id}-address">${center.address}</span>
                        </div>
                        <button class="btn btn-primary" data-idx="${center.id}" onclick="saveCenter(this)">저장하기</button>
                    </div>
                </div>
                <div class="card-footer">
                    <small>Last updated ${center.updatedAt}</small>
                </div>
             </div>
        `;
    });

    return html;
}