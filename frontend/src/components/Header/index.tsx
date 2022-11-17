import logo from '../../assets/img/logo.svg';
import './styles.css';

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="Logotipo"/>
                <h1>DSMeta</h1>
                <p>
                    Desenvolvido por <a href="https://github.com/offjaao">@offjaao</a>
                </p>
            </div>
        </header>
    )

}

export default Header;