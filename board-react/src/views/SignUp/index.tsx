import axios from 'axios';
import React, {useState, useEffect} from 'react';
 
export default function SignUp() {  
    const [requestResult, setRequestResult] = useState<String>(" ");

    const signUpHandler = () => {
        const data = {
                "userEmail": "4562sky@naver.com",
                "userPassword": "qwerty1234!!",
                "userPasswordCheck" : "qwerty1234!!",
                "userNickname": "hannin",
                "userPhoneNumber": "010-456-456",
                "userAddress": "부산 금정구",
                "userAddressDetail": "남산동"
        };

        axios.post('http://localhost:4000/api/auth/signUp', data)
        .then((response) => { 
            setRequestResult('success!!');
        })
        .catch((error) => {
            setRequestResult('Failed!!');
        })
    };
  return (
    <div>
        <h3>{requestResult}</h3>
        <button onClick={() => signUpHandler()}>회원가입</button>


    </div>
  )
}
