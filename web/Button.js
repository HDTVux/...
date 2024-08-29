document.getElementById('btnShowPhongBan').addEventListener('click', function () {
    var phongBanTableContainer = document.getElementById('phongBanTableContainer');
    phongBanTableContainer.style.display = phongBanTableContainer.style.display === 'none' ? 'block' : 'none';
    document.getElementById('employeeTableContainer').style.display = 'none';
    document.getElementById('addEmployeeForm').style.display = 'none';
    document.getElementById('deleteEmployeeForm').style.display = 'none';
    toggleWelcomeMessage();
});

document.getElementById('toggleTableBtn').addEventListener('click', function () {
    var employeeTableContainer = document.getElementById('employeeTableContainer');
    employeeTableContainer.style.display = employeeTableContainer.style.display === 'none' ? 'block' : 'none';
    document.getElementById('phongBanTableContainer').style.display = 'none';
    document.getElementById('addEmployeeForm').style.display = 'none';
    document.getElementById('deleteEmployeeForm').style.display = 'none';
    toggleWelcomeMessage();
});

document.getElementById('btnShowForm').addEventListener('click', function () {
    var addEmployeeForm = document.getElementById('addEmployeeForm');
    addEmployeeForm.style.display = addEmployeeForm.style.display === 'none' ? 'block' : 'none';
    document.getElementById('employeeTableContainer').style.display = 'none';
    document.getElementById('phongBanTableContainer').style.display = 'none';
    document.getElementById('deleteEmployeeForm').style.display = 'none';
    toggleWelcomeMessage();
});

document.getElementById('btnShowLinkEmployee').addEventListener('click', function () {
    var linkEmployeeForm = document.getElementById('linkEmployeeForm');
    linkEmployeeForm.style.display = linkEmployeeForm.style.display === 'none' ? 'block' : 'none';
    document.getElementById('employeeTableContainer').style.display = 'none';
    document.getElementById('phongBanTableContainer').style.display = 'none';
    document.getElementById('addEmployeeForm').style.display = 'none';
    document.getElementById('deleteEmployeeForm').style.display = 'none';
    toggleWelcomeMessage();
});

document.getElementById('btnShowDeleteForm').addEventListener('click', function () {
    var deleteEmployeeForm = document.getElementById('deleteEmployeeForm');
    deleteEmployeeForm.style.display = deleteEmployeeForm.style.display === 'none' ? 'block' : 'none';
    document.getElementById('employeeTableContainer').style.display = 'none';
    document.getElementById('phongBanTableContainer').style.display = 'none';
    document.getElementById('addEmployeeForm').style.display = 'none';
    toggleWelcomeMessage();
});

document.addEventListener('DOMContentLoaded', function () {
    var phongBanCodes = document.querySelectorAll('.phongban-code');

    phongBanCodes.forEach(function (code) {
        code.addEventListener('click', function () {
            var phongBanId = code.parentElement.getAttribute('data-phongban');
            var nhanVienInfoRows = document.querySelectorAll('.nhanvien-info[data-phongban="' + phongBanId + '"]');

            nhanVienInfoRows.forEach(function (row) {
                if (row.classList.contains('hidden')) {
                    row.classList.remove('hidden');
                } else {
                    row.classList.add('hidden');
                }
            });
        });
    });
});
document.getElementById('btnShowAddPhongBanForm').addEventListener('click', function () {
    var addPhongBanForm = document.getElementById('addPhongBanForm');
    addPhongBanForm.style.display = addPhongBanForm.style.display === 'none' ? 'block' : 'none';
    hideOtherSections('addPhongBanForm'); // Ẩn các phần nội dung khác khi hiển thị form
    toggleWelcomeMessage();
});


function toggleWelcomeMessage() {
    var addEmployeeForm = document.getElementById('addEmployeeForm');
    var deleteEmployeeForm = document.getElementById('deleteEmployeeForm');
    var employeeTableContainer = document.getElementById('employeeTableContainer');
    var phongBanTableContainer = document.getElementById('phongBanTableContainer');
    var welcomeMessage = document.getElementById('welcomeMessage');

    if (addEmployeeForm.style.display === 'none' && deleteEmployeeForm.style.display === 'none' &&
            employeeTableContainer.style.display === 'none' && phongBanTableContainer.style.display === 'none') {
        welcomeMessage.style.display = 'block';
    } else {
        welcomeMessage.style.display = 'none';
    }
}

function checkSearchQuery() {
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('search')) {
        document.getElementById('employeeTableContainer').style.display = 'block';
        document.getElementById('phongBanTableContainer').style.display = 'none';
        document.getElementById('addEmployeeForm').style.display = 'none';
        document.getElementById('deleteEmployeeForm').style.display = 'none';
    }
}

// Initial call to show the welcome message if no section is displayed
toggleWelcomeMessage();
checkSearchQuery();
