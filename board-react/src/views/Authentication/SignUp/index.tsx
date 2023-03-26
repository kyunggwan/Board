import { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Card from '@mui/material/Card';
import { Button, Typography } from '@mui/material';
import { signUpApi } from '../../../apis';
 
interface Props{
    setAuthView: (authView: boolean) => void,
}

export default function SignUp(props: Props) {  
    const [userEmail, setUserEmail] = useState<String>('');
    const [userPassword, setuserPassword] = useState<String>('');
    const [userPasswordCheck, setuserPasswordCheck] = useState<String>('');
    const [userNickname, setuserNickname] = useState<String>('');
    const [userPhoneNumber, setuserPhoneNumber] = useState<String>('');
    const [userAddress, setuserAddress] = useState<String>('');
    const [userAddressDetail, setuserAddressDetail] = useState<String>('');

    const { setAuthView } = props;

    const signUpHandler = async () => {
        const data = {
                "userEmail": userEmail,
                "userPassword": userPassword,
                "userPasswordCheck": userPasswordCheck,
                "userNickname":  userNickname,
                "userPhoneNumber": userPhoneNumber,
                "userAddress": userAddress,
                "userAddressDetail": userAddressDetail
        };
        const signUpResponse = await signUpApi(data);
        if (!signUpResponse) {
            alert("회원가입에 실패했습니다.");
            return;
        }
        if (!signUpResponse.result) {
            alert("회원가입에 실패했습니다.");
            return;
        }
        alert("회원가입에 성공했습니다.");
        setAuthView(false);
    };
  return (
    <Card sx={{ minWidth: 275, maxWidth:"50vw", padding: 5 }}>
            <Box>
                <Typography variant='h5'>회원가입</Typography>
            </Box>  
            <Box height={'50vh'}>
                <TextField fullWidth  label="이메일 주소" type = "email" variant="standard" onChange={(e) => setUserEmail(e.target.value)}/>
                <TextField fullWidth  label="비밀번호" type = "password" variant="standard" onChange={(e) => setuserPassword(e.target.value)}/>
                <TextField fullWidth  label="비밀번호 확인" type = "password" variant="standard" onChange={(e) => setuserPasswordCheck(e.target.value)}/>
                <TextField fullWidth  label="닉네임" variant="standard" onChange={(e) => setuserNickname(e.target.value)} />
                <TextField fullWidth  label="휴대폰 번호" variant="standard" onChange={(e) => setuserPhoneNumber(e.target.value)}/>
                <TextField fullWidth  label="주소" variant="standard" onChange={(e) => setuserAddress(e.target.value)}/>
                <TextField fullWidth  label="상세주소" variant="standard"onChange={(e) => setuserAddressDetail(e.target.value)} />
            </Box>  
            <Box>
                <Button fullWidth onClick={() => signUpHandler()} variant="contained">회원가입</Button>           
            </Box>
            <Box component='div' display='flex' mt={2}>
                <Typography>이미 계정이 있으신가요?</Typography>
                <Typography fontWeight={800} ml={1} onClick={() => setAuthView(false)}>로그인</Typography>
            </Box>          
    </Card>
    
  )
}
