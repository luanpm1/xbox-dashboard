"use strict";
/*** REGION 1 - Global variables - Vùng khai báo biến, hằng số, tham số TOÀN CỤC */

const gBASE_URL = "http://127.0.0.1:8000/projects/";

let gId;

const gColumns = [
    'id',
    'name',
    'slogan',
    'description',
    'acreage',
    'constructArea',
    'numBlock',
    'numFloors',
    'numApartment',
    'apartmentArea',
    'investor',
    'constructionContractor',
    'designUnit',
    'utilities',
    'regionLink',
    'photo',
    '_lat',
    '_lng',
    'action'
];



const gDataTable = $("table").DataTable({
    columns: [
        { data: gColumns[0], title: "id" },
        { data: gColumns[1], title: "name" },
        { data: gColumns[2], title: "slogan" },
        { data: gColumns[3], title: "description" },
        { data: gColumns[4], title: "acreage" },
        { data: gColumns[5], title: "constructArea" },
        { data: gColumns[6], title: "numBlock" },
        { data: gColumns[7], title: "numFloors" },
        { data: gColumns[8], title: "numApartment" },
        { data: gColumns[9], title: "apartmentArea" },
        { data: gColumns[10], title: "investor" },
        { data: gColumns[11], title: "constructionContractor" },
        { data: gColumns[12], title: "designUnit" },
        { data: gColumns[13], title: "utilities" },
        { data: gColumns[14], title: "regionLink" },
        { data: gColumns[15], title: "photo" },
        { data: gColumns[16], title: "_lat" },
        { data: gColumns[17], title: "_lng" },
        { data: gColumns[18], title: "action" }

    ],
    columnDefs: [
        {
            targets: 18,
            defaultContent: `<button class='btn-edit btn-link' data-toggle="tooltip" data-placement="bottom"
            title="Item Edit"><i  class="fa-solid fa-cube fa-lg text-secondary"></i></button>
                    <button class='btn-delete btn-link' data-toggle="tooltip" data-placement="bottom"
                    title="Item Delete"><i  class="fa-solid fa-user-minus fa-lg text-secondary"></i></button>`
        },
        {
            targets: 15,
            render: function (data) {
                // console.log(data);
                return `<img style="height: 100px;width: 100px;" src="${data}" alt="">`
            }
        }
    ]

})
/*** REGION 2 - Vùng gán / thực thi hàm xử lý sự kiện cho các elements */
// Hàm xử lý sự kiện tải trang
function onPageLoading() {
    
    //    console.log("loading...");

    $.ajax({
        url: gBASE_URL,
        type: 'get',
        success: function (success) {
            // console.log(paramSuccess);
            // Funtion show data to table
            gDataTable.clear();
            gDataTable.rows.add(success);
            gDataTable.draw();

        },
        error: function (err) {
            alert("err");
        }
    })


}










