let img = document.getElementById('imageInput');
if (img !== null) {
    img.addEventListener('change', function (event) {
        const file = event.target.files[0];

        if (file) {
            const reader = new FileReader();

            reader.onload = function (e) {
                const imagePreview = document.getElementById('imagePreview');
                imagePreview.src = e.target.result;
                document.getElementById("avatar").value = e.target.result;
                imagePreview.style.display = 'block';
            };

            reader.readAsDataURL(file);
        } else {
            alert("No file selected");
        }
    });
}


document.querySelectorAll(".btn-outline-danger").forEach(el => {
    el.addEventListener("click", function (e) {
        //     confirm before delete
        if (!confirm("Bạn có muốn xóa không?")) {
            e.preventDefault()
        }
    })
})


//validate form
document.querySelectorAll(".required-three-character").forEach(el => {
    el.addEventListener("keyup", function () {
        console.log("hello")
        if (el.value.length < 5) {
            el.classList.add("is-invalid")
        } else {
            el.classList.remove("is-invalid")
            el.classList.add("is-valid")
        }
    })
})


document.querySelectorAll("form").forEach(el => {
    el.addEventListener("submit", function (e) {
        if (el.querySelectorAll(".is-invalid").length > 0) {
            e.preventDefault()
            alert("Vui lòng điền đầy đủ thông tin")
        }
    })
})