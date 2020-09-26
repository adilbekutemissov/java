
let clickButton = document.querySelector("#clickButton");


clickButton.addEventListener('click', (e) => { sendGetCheck()});

function sendGetCheck() {

    let xhr = new XMLHttpRequest();

// 2. configure GET for URL 'phones.json'
    xhr.open('GET', 'flight/getAllFlight', false);

// 3. send request
    xhr.send();

// 4. if response status 200, then error
    if (xhr.status != 200) {
        alert(xhr.status + ': ' + xhr.statusText);
    } else {
        let flightsResponse = JSON.parse(xhr.response);
        let flightLinks = document.createElement('span')
        for (let i in flightsResponse){
            let link = document.createElement('button')
            link.innerHTML = "From " + flightsResponse[i].department + " to " + flightsResponse[i].arrival;
            link.id = flightsResponse[i].planeid
            link.className = "flightButton"
            flightLinks.appendChild(link)
            link.addEventListener('click', () => showSeats(link.id))
            flightLinks.appendChild(document.createElement('br'))
            flightLinks.appendChild(document.createElement('br'))
        }
        document.getElementById("flights").innerText =  "";
        document.getElementById("flights").appendChild(flightLinks);
    }
}

function showSeats(planeid) {

    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'planeseat/showNumbersByPlaneid/' + planeid, false);
    xhr.send();

    if (xhr.status != 200) {
        console.log('xhr.status: ', xhr.statusText)
        }
    else {
        let planeSeatsResponse = JSON.parse(xhr.response);
        let seatButtons = document.createElement('span')
        for (let i in planeSeatsResponse){
            let seatButton = document.createElement('button')
            if (planeSeatsResponse[i].free === false){
                seatButton.className = "notFreeSeat"
                seatButton.disabled = true
            }
            else {
                seatButton.className = "seatButton"
            }

            seatButton.setAttribute('planeid', planeSeatsResponse[i].planeid)
            seatButton.id = planeSeatsResponse[i].number + "_" + planeSeatsResponse[i].planeid;
            seatButton.innerText = planeSeatsResponse[i].number
            seatButton.addEventListener('click', () => bookSeat(seatButton.getAttribute('planeid'), planeSeatsResponse[i].number, seatButton.id));

            seatButtons.appendChild(seatButton)
        }
        document.getElementById('seats').innerText = ""
        document.getElementById('seats').appendChild(seatButtons)
    }
}


function bookSeat(planeid, seatNumber, planeseatId) {
    setNotFree(planeseatId)
    let xhr = new XMLHttpRequest();
    xhr.open('put', "planeseat/bookingPlaneSeat/" + planeid + "/"+ seatNumber + "?free=false", false);
    xhr.send();
}

if (window.Worker){
    console.log("Worker is avalible! ")
    worker = new Worker('worker.js');

    worker.onmessage = e => {setNotFree(e.data)}
    console.log(worker)
}

function setNotFree(planeseatId) {
    (document.getElementById(planeseatId) || {}).className = "notFreeSeat";
    (document.getElementById(planeseatId) || {}).disabled = true
}

