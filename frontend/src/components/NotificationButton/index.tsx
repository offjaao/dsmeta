import not from '../../assets/img/not.png';
import './styles.css';
import { BASE_URL } from '../../utils/requests';
import axios from "axios";
import {toast} from "react-toastify";

type Props = {
    saleId: number;
}

function handleClick(id: number){
    axios(`${BASE_URL}/sales/${id}/notification`)
    .then(response => {
        toast.success("Vendedor notificado através do SMS!")
    })
}

function NotificationButton( {saleId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={not} alt="Notificar"></img>
        </div>
    )

}

export default NotificationButton;