setInterval(timer , 1000)

function timer() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/plane/getAllPlanes', false);
    xhr.send();
    let planeSeats = JSON.parse(xhr.responseText)
    for (i in planeSeats){
        let planeSeatsByPlane = planeSeats[i].planeseatsById
        for (j in planeSeatsByPlane){
            this.postMessage(planeSeatsByPlane[j])
            if (planeSeatsByPlane[j].free === false){
                let notFreeId = planeSeatsByPlane[j].number + "_" + planeSeats[i].id
                this.postMessage(notFreeId)
            }
        }
    }
}