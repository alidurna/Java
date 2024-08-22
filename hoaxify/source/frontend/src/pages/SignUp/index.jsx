import { useState } from "react";

export function SignUp() {
  const [username, setUsername] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [passwordRepeat, setPasswordRepeat] = useState();

  return (
    <>
      <h1>Sign Up</h1>

      <div>
        <label htmlFor="username">UserName</label>
        <input
          id="username"
          type="text"
          onChange={(event) => setUsername(event.target.value)}
        />
      </div>

      <div>
        <label htmlFor="email">E-mail</label>
        <input
          id="email"
          type="text"
          onChange={(event) => setEmail(event.target.value)}
        />
      </div>

      <div>
        <label htmlFor="password">Password</label>
        <input
          id="password"
          type="password"
          onChange={(event) => setPassword(event.target.value)}
        />
      </div>

      <div>
        <label htmlFor="passwordRepeat">Password Repeat</label>
        <input
          id="passwordRepeat"
          type="password"
          onChange={(event) => setPasswordRepeat(event.target.value)}
        />
      </div>
      <button disabled={!password || password !== passwordRepeat}>
        Sign Up
      </button>
    </>
  );
}
