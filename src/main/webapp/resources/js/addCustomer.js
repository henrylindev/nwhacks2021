function createCustomer() {
    console.log("called");
    var formObj = gatherFormInfo();
    // console.log(formObj);
    // var url = window.location.href;
    // var urlComponents = url.split('?');
    // var slipString = urlComponents[1];
    // console.log(slipString);
    axios.post('http://localhost:8080/SReid-final-prep/api/customers/addCustomer'
                + '?customerNumber=' + Math.floor((Math.random() * 10000) + 1000)
                + '&customerName=' + formObj.customer_name
                + '&contactLastName=' + formObj.contact_last_name
                + '&contactFirstName=' + formObj.contact_first_name
                + '&phone=' + formObj.phone_num
                + '&addressLine1=' + formObj.address_line_1
                + '&addressLine2=asdffdsd&city=' + formObj.address_line_2
                + '&state=' + formObj.state
                + '&postalCode=' + formObj.postal_code
                + '&country=' + formObj.country
                + '&salesRepEmployeeNumber=' + 1111
                + '&creditLimit=' + 5000/*, {
        "slip": slipString
    }*/).then( function (response) {
        console.log(response);
        // console.log(response.data.booking.session.id);
        // var sessionID = response.data.booking.session.id;
        // // console.log(formObj);
        // axios.post('https://reidsm100.checkfront.com/api/3.0/booking/create', {
        //     "session_id": sessionID,
        //     "form": formObj,
        //     "slip": slipString
        // }).then(function(postBookingResponse){
        //     console.log(postBookingResponse);
        //     var bookingID = postBookingResponse.data.booking.id;
        //     console.log(bookingID)
        //     var bookingUpdatePost = axios.post('https://reidsm100.checkfront.com/api/3.0/booking/' + bookingID + '/update', {
        //         "status_id": "HOLD",
        //         // "notify": 0,
        //         // "set_paid": 0
        //     });
        //     console.log(bookingUpdatePost);
        // });
    });
    // console.log(postVar);
}





function gatherFormInfo() {
    var companyName = document.getElementById('companyName').value;
    var contactLastName = document.getElementById('contactLastName').value;
    var contactFirstName = document.getElementById('contactFirstName').value;
    var phoneNum = document.getElementById('phoneNum').value;
    var addressLine1 = document.getElementById('addressLine1').value;
    var AddressLine2 = document.getElementById('AddressLine2').value;
    var city = document.getElementById('city').value;
    var state = document.getElementById('state').value;
    var postalCode = document.getElementById('postalCode').value;
    var country = document.getElementById('country').value;

    return { "customer_name": companyName, 
             "contact_last_name": contactLastName,
             "contact_first_name": contactFirstName,
             "phone_num": phoneNum,
             "address_line_1": addressLine1,
             "address_line_2": AddressLine2,
             "city": city,
             "state": state,
             "postal_code": postalCode,
             "country": country };
}