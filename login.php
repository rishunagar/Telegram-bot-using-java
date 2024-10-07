<?php

// Retrieve form data
$name = $_POST['name'];
$email = $_POST['email'];
$password = $_POST['password'];

// Validate the login (You should replace this with proper validation and database check)
if ($name === "your_username" && $email === "your_email@example.com" && $password === "your_password") {
    $response = array("success" => true);
} else {
    $response = array("success" => false, "message" => "Invalid login credentials.");
}

// Return the response as JSON
echo json_encode($response);

?>
