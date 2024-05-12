function redirectToCheckReservation() {
        var startDateTime = document.getElementById("start-datetime").value;
        var endDateTime = document.getElementById("end-datetime").value;

        // URL에 GET 파라미터를 추가하여 리다이렉트
        window.location.href = "/CheckReservation?startDateTime=" + encodeURIComponent(startDateTime) + "&endDateTime=" + encodeURIComponent(endDateTime);
    }