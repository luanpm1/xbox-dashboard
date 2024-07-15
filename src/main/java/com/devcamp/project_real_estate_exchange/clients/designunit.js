"use strict";
/*** REGION 1 - Global variables - Vùng khai báo biến, hằng số, tham số TOÀN CỤC */

const gBASE_URL = "http://127.0.0.1:8000/design_units/";

let gId;

const gColumns = [
    'id',
    'name',
    'description',
    'projects',
    'address',
    'phone',
    'phone2',
    'fax',
    'email',
    'website',
    'action'
];



const gDataTable = $("table").DataTable({
    columns: [
        { data: gColumns[0], title: "id" },
        { data: gColumns[1], title: "name" },
        { data: gColumns[2], title: "description" },
        { data: gColumns[3], title: "projects" },
        { data: gColumns[4], title: "address" },
        { data: gColumns[5], title: "phone" },
        { data: gColumns[6], title: "phone2" },
        { data: gColumns[7], title: "fax" },
        { data: gColumns[8], title: "email" },
        { data: gColumns[9], title: "website" },
        { data: gColumns[10], title: "action" }

    ],
    columnDefs: [
        {
            targets: 10,
            defaultContent: `<button class='btn-edit btn-link' data-toggle="tooltip" data-placement="bottom"
            title="Item Edit"><i  class="fa-solid fa-cube fa-lg text-secondary"></i></button>
                    <button class='btn-delete btn-link' data-toggle="tooltip" data-placement="bottom"
                    title="Item Delete"><i  class="fa-solid fa-user-minus fa-lg text-secondary"></i></button>`
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










