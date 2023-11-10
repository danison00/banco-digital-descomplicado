
function deposito() {

    var numberAccount = document.getElementById("numberAcc").value;
    var value = document.getElementById("value").value;

    var data = {
        "accountNumber": numberAccount,
        "value": value,
    }

    fetch('http://localhost:8080/api/transaction/deposit', {
        method: 'POST', // ou 'POST', 'PUT', 'DELETE', etc., dependendo do tipo de requisição que você deseja fazer

        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {

            if (response.ok) {
                alert("deposito realizado com sucesso")
            }
            else {

                console.log(response.status);

            }


        })
        .catch(error => {
            // Aqui você trata erros da requisição
        });

}
function transferir() {

    var numberAccount = document.getElementById("numberAccount").value;
    var value = document.getElementById("valueTranfer").value;
    var fav = false;
    if (document.getElementById("fav").checked) fav = true;
    var data = {

        "accountDestination": numberAccount,
        "value": value,
        "saveDestination": fav

    }
    fetch('http://localhost:8080/api/transaction/transfer', {
        method: 'POST', // ou 'POST', 'PUT', 'DELETE', etc., dependendo do tipo de requisição que você deseja fazer

        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {

            if (response.ok) {
                alert("tranferência realizada com sucesso")
            }
            else {

                console.log(response.status);
                if (response.status == "403") {
                    document.location.href = "http://localhost:8080/log";
                }


            }


        })
        .catch(error => {
            // Aqui você trata erros da requisição
        });


}
function buscarDados() {



    fetch('http://localhost:8080/api/my-account', {
        method: 'GET', // ou 'POST', 'PUT', 'DELETE', etc., dependendo do tipo de requisição que você deseja fazer

    })
        .then(response => {

            if (response.redirected) {
                window.location.href = response.url;
            }
            else {

                return response.json();



            }


        })
        .then(data => {



            console.log(data);
        })
        .catch(error => {
            // Aqui você trata erros da requisição
        });
}
function logout() {
    fetch('http://localhost:8080/api-public/logout', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (response.ok) {

                if (response.redirected)
                    window.location.href = response.url;
               

            }

        })
        .catch(error => {

            alert("Erro na requisição: " + error.message);
            console.log(error.message);
        });
}
