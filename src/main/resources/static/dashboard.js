const token = localStorage.getItem("token");

const result =
    document.getElementById("result");

if (!token) {

    window.location.href = "/login.html";
}

async function loadProtectedData() {

    try {

        const response = await fetch(
            "http://localhost:8080/api/user/profile",
            {
                method: "GET",

                headers: {
                    "Authorization":
                        "Bearer " + token
                }
            }
        );

        if (response.ok) {

            const data = await response.text();

            result.innerText = data;

        } else {

            result.innerText =
                "Access denied";
        }

    } catch (error) {

        result.innerText =
            "Something went wrong";
    }
}

function logout() {

    localStorage.removeItem("token");

    window.location.href = "/login.html";
}

loadProtectedData();