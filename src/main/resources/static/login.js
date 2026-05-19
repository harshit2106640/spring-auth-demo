const loginForm =
    document.getElementById("loginForm");

const message =
    document.getElementById("message");

loginForm.addEventListener(
    "submit",
    async (e) => {

        e.preventDefault();

        const email =
            document.getElementById("email").value;

        const password =
            document.getElementById("password").value;

        try {

            const response = await fetch(
                "http://localhost:8080/api/auth/login",
                {
                    method: "POST",

                    headers: {
                        "Content-Type": "application/json"
                    },

                    body: JSON.stringify({
                        email,
                        password
                    })
                }
            );

            const data = await response.json();

            console.log("Login Response:", data);

            if (response.ok && data.token) {

                localStorage.setItem(
                    "token",
                    data.token
                );

                console.log(
                    "Stored Token:",
                    localStorage.getItem("token")
                );

                message.style.color = "green";

                message.innerText =
                    "Login successful";

                setTimeout(() => {

                    window.location.href =
                        "/dashboard.html";

                }, 1000);

            } else {

                message.style.color = "red";

                message.innerText =
                    data.message || "Login failed";
            }

        } catch (error) {

            console.error(error);

            message.style.color = "red";

            message.innerText =
                "Something went wrong";
        }
    }
);