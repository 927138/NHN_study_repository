//TODO#1 - DomContentLoaded 모든 HTML 문서가 로드된 상태 - 그래야 DOM element에 접근할 수 있음
const SERVER_URL="http://133.186.241.167:8100";
window.addEventListener("DOMContentLoaded",function(){
    //TODO#2 - strict 모드 설정
    'use strict';

    const loginForm = document.getElementById("login-form");
    //#TODO#5 login form validation 
    // 아이디 비밀번호 공백체크 및 focus 처리
    
    const validateForm=function(form){
        if(form['userId'].value.trim() == '' ){
            alert("userId empty!");
            form['userId'].focus();
            return false;
        }
        if(form['userPassword'].value.trim() == '' ){
            alert("userPassword empty!");
            form['userPassword'].focus();
            return false;
        }
    }

    //TODO#3 loginForm submit(전송) 이벤트 등록 submit 이벤트는 로그인 button을 클릭했을때 발생됨 
    // 단 로그인 버튼의 button type = 'submit'이어야 함, type='button'동작 안 함
    loginForm.addEventListener("submit", async function(event){
        event.preventDefault();
        //TODO#4 loginForm validation 실행 
        //event.target = form 자체를 의미함.
        if( validateForm(event.target)==false ){
            return ;
        }

        const userId = event.target["userId"].value;
        const userPassword = event.target["userPassword"].value;

        let user;

        try {
            user = await doLogin(userId, userPassword);
            console.log(user);
        } catch (error) {
            console.log(error);
            return;
        }

        let items;
        try {
            items = await getCartItems(user.userId, user.cartId);
            console.log(items);
            
            const cartTable = document.getElementById("cart-table");
            const body = cartTable.getElementsByTagName("tbody")[0];

            for (const item of items) {
                const tr = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");
                console.log(tr);
                td1.innerText=item.productId;
                td2.innerText=item.name;
                td3.innerText=item.price;
                td4.innerText=item.amount;
                td5.innerText= item.totalPrice;
                tr.append(td1,td2,td3,td4,td5);
                body.append(tr);
            }

        } catch (error) {
            console.log(error);
            // alert(error);
            return;
        }


        // doLogin(event.target["userId"].value, event.target["userPassword"].value)
        //     .then((user)=> {
        //         console.log("userId : " + user.userId);
        //         console.log("cartId : " + user.cartId);

        //         const loginWrapper = document.getElementById("login-wrapper");
        //         loginWrapper.setAttribute("style","display:none;");
        //         const loginSuccess = document.getElementById("login-success");
        //         loginSuccess.setAttribute("style","display:block");
                
        //         const loginUserId = document.getElementById("login-userId");
        //         const loginUserName = document.getElementById("login-userName");
        //         const loginCartId = document.getElementById("login-cartId");

        //         loginUserId.innerText=user.userId;
        //         loginUserName.innerText=user.userName;
        //         loginCartId.innerText=user.cartId;
        //         return user;
        //     }).then(user => getCartItems(user.userId, user.cartId)
        //     ).then((items)=>{
        //         const cartTable = document.getElementById("cart-table");
        //         const body = cartTable.getElementsByTagName("tbody")[0];
        //         const intl = new Intl.NumberFormat();

        //         for (const item of items) {
        //             const tr = document.createElement("tr");
        //             const td1 = document.createElement("td");
        //             const td2 = document.createElement("td");
        //             const td3 = document.createElement("td");
        //             const td4 = document.createElement("td");
        //             const td5 = document.createElement("td");
        //             console.log(tr);
        //             td1.innerText=item.productId;
        //             td2.innerText=item.name;
        //             td3.innerText=intl.format(item.price);
        //             td4.innerText=intl.format(item.amount);
        //             td5.innerText= intl.format(item.totalPrice);
        //             tr.append(td1,td2,td3,td4,td5);
        //             body.append(tr);
        //         }
        //     })

    });
});

//TODO#7 로그인 처리
async function doLogin(userId, userPassword){

    const url = SERVER_URL+"/api/users/login";
    const data = {
        userId : userId,
        userPassword : userPassword
    };
    const options = {
        method : 'POST',
        headers : {
            'Content-type' : 'application/json'
        },
        body : JSON.stringify(data)
    };
    
    const response = await fetch(url, options);
    if(!response.ok){
        throw new Error("login error");
    }

    return await response.json();
}

//TODO#11 cart-api 호출
async function getCartItems(userId, cartId){

    console.log(userId + ", " + cartId)
    const url = SERVER_URL + "/api/nhnmart/shopping-cart/" + cartId;
    const options = {
        method : 'GET',
        headers : {
            'Content-type' : 'application/json',
            'X-USER-ID' : userId
        }
    };

    const fetchPromise = await fetch(url, options);
    if(!fetchPromise.ok){
        throw new Error("cart items error");
    }

    return await fetchPromise.json();
    
}