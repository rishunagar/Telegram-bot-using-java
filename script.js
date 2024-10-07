function submitForm() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    // Validate the form data (you can add more validation as needed)
    if (name.trim() === "" || email.trim() === "" || password.trim() === "") {
        document.getElementById("errorMessage").innerText = "All fields are required.";
        return;
    }

    // Send the form data to the PHP script using AJAX
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "login.php", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var response = JSON.parse(xhr.responseText);
            if (response.success) {
                window.location.href = "dashboard.html";
            } else {
                document.getElementById("errorMessage").innerText = response.message;
            }
        }
    };
    xhr.send("name=" + name + "&email=" + email + "&password=" + password);
}
