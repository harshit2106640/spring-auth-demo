const registerForm =
    document.getElementById("registerForm");

const message =
    document.getElementById("message");

registerForm.addEventListener(
    "submit",
    async (e) => {

        e.preventDefault();

        const name =
            document.getElementById("name").value;

        const email =
            document.getElementById("email").value;

        const password =
            document.getElementById("password").value;

        const userData = {
            name,
            email,
            password
        };

        try {

            const response = await fetch(
                "http://localhost:8080/api/auth/register",
                {
                    method: "POST",

                    headers: {
                        "Content-Type": "application/json"
                    },

                    body: JSON.stringify(userData)
                }
            );

            const data = await response.json();

            if (response.ok) {

                message.style.color = "green";

                message.innerText =
                    data.message;

            } else {

                message.style.color = "red";

                if (typeof data === "object") {

                    message.innerText =
                        Object.values(data).join(", ");

                } else {

                    message.innerText = data.message;
                }
            }

        } catch (error) {

            message.style.color = "red";

            message.innerText =
                "Something went wrong";
        }
    }
);