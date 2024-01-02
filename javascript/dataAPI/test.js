const SERVICE_KEY = "IipE3uavt9EYSuNrLmdVt%2F1g5LqHAYF2ff8JNpLEP6e3ZmXvipYNMSTbeBq4rXQVSVz0AaH12w4fevvB0xZAAw%3D%3D";

window.addEventListener("DOMContentLoaded", async function(){
   console.log(await getAirlineList());
   getAirportList();
});

async function getAirlineList(){
   let url = 'http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getAirmanList'; /*URL*/
   let queryParams = '?' + encodeURIComponent('serviceKey') + '='+SERVICE_KEY; /*Service Key*/
   queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); /**/
   url+=queryParams;
   //TODO#1 항공사 리스트 구하기
  
  const response = await fetch(url);
  if(!response.ok){
     throw new Error("AirlineList error");
  }
  const json = await response.json();
  
  return json.response.body.items.item;
}

async function getAirportList(){
   let url = "http://apis.data.go.kr/1613000/DmstcFlightNvgInfoService/getArprtList";
       let queryParams = '?' + encodeURIComponent('serviceKey') + '='+SERVICE_KEY; /*Service Key*/
           queryParams += '&' + encodeURIComponent('_type') + '=' + encodeURIComponent('json'); /**/
           url+=queryParams;
           //TODO#2 공항리스트 구하기
      
      const response = await fetch(url);
      console.log(await response);
}