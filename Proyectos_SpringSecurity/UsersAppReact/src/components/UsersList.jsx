import { useContext } from "react"
import { UserContext } from "../context/UserContext"
import { AuthContext } from "../auth/context/AuthContext"
import { UserRow } from "./UserRow"

export const UsersList = () => {

    const { users } = useContext(UserContext);
    const { login } = useContext(AuthContext);
    return (
        <table className="table table-hover table-striped">

            <thead>
                <tr>
                    <th>#</th>
                    <th>username</th>
                    <th>email</th>
                    {!login.isAdmin || <>
                    <th>update</th>
                    <th>update route</th>
                    <th>remove</th>
                    </>
                    }   
                </tr>
            </thead>
            <tbody>
                {
                    users.map(({id, username, email }) => (
                        <UserRow
                            key={id}
                            id={id}
                            username={username}
                            email={email} />
                    ))
                }
            </tbody>
        </table>
    )
}