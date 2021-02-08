function createAccount() {

    let customer = {

        firstName: document.getElementById('fname-createA').value,
        lastName: document.getElementById('lname-createA').value
    }

    fetch('http://localhost:8081/bankhib/createaccount',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(customer)
        })
        .then(result => result.json())
        .then(result =>{

            document.getElementById('createacc').innerHTML = 'Account nr:' + result.accountNumber + ' created for: ' + result.firstName + ' ' + result.lastName


        });
}

function createCustomer() {
    let customer = {

        firstName: document.getElementById('fname-createC').value,
        lastName: document.getElementById('lname-createC').value
    }

    fetch('http://localhost:8081/bankhib/createcustomer',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(customer)
        })

        .then(response => response.json())
        .then(response =>{
            document.getElementById('createcus').innerHTML = 'Customer created: ' + response.firstName + ' ' + response.lastName;

        })

}

function deposit() {
    let deposit = {

        sum: document.getElementById('sum-deposit').value,
        account: document.getElementById('nr-account-deposit').value
    }

    fetch('http://localhost:8081/bankhib/deposit',
        {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(deposit)
        })

        .then(response => response.json())
        .then(response =>{
            document.getElementById('deposit').innerHTML = response.sum  + ' was added to account: ' + response.account;

        })

}

function withdraw() {
    let withdraw = {

        sum: document.getElementById('sum-withdraw').value,
        account: document.getElementById('nr-account-withdraw').value
    }

    fetch('http://localhost:8081/bankhib/withdraw',
        {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(withdraw)
        })

        .then(response => response.json())
        .then(response =>{
            document.getElementById('withdraw').innerHTML = response.sum + ' was withdrawn from account:  ' + response.account;

        })

}



function transfer() {
    let transfer = {

        sum: document.getElementById('transfer-sum').value,
        accountFrom: document.getElementById('account-from').value,
        accountTo: document.getElementById('account-to').value,
    }

    fetch('http://localhost:8081/bankhib/transfer',
        {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(transfer)
        })

        .then(response => response.json())
        .then(response =>{
            document.getElementById('transferdiv').innerHTML = response.sum + ' was transferred from account: ' + response.accountFrom + ' to account: ' + response.accountTo;

        })

}

function getBalance() {
    let balance = {
        account: document.getElementById('abalance').value
    }

    fetch('http://localhost:8081/bankhib/balance',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },

            body: JSON.stringify(balance)
        })

        .then(response => response.json())
        .then(response =>{
            document.getElementById('balancechk').innerHTML = 'Account : ' + response.account + " balance: " + response.sum;

        })

}

