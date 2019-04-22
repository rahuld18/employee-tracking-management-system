/*
Notification.requestPermission();
data={
		msg:"Fill all task",
		
}

var e= new Notification("Reminder",{
	body:data.msg,
	icon:"https://digimonk.in/images/logo%20white%20[small].png"
}
		);

*/
navigator.serviceWorker.register('sw.js');
Notification.requestPermission();
showNotification();
function showNotification() {
  Notification.requestPermission(function(result) {
    if (result === 'granted') {
      navigator.serviceWorker.ready.then(function(registration) {
        registration.showNotification('Vibration Sample', {
          body: 'Buzz! Buzz!',
          //icon: '../images/touch/chrome-touch-icon-192x192.png',
          vibrate: [200, 100, 200, 100, 200, 100, 200],
          tag: 'vibration-sample'
        });
      });
    }
  });
}