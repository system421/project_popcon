import './MainNavigation.css'
import { Link, useRouteLoaderData, Form } from "react-router-dom";


export default function MainNavigation(){
    
    const token = useRouteLoaderData('tokenRoot');
    console.log("MainNavigation.token", token);

    return (
      <header className="border-bottom border-light border-5 mb-5 p-2">
      <div className="container">
          <div className="row">
              <nav className="navbar navbar-expand-lg">
               
                  <Link className="navbar-brand ms-2 fs-2 fw-bold text-black" to="#"></Link>
                  <div className="collapse navbar-collapse">
                      <ul className="navbar-nav">

                          <li className="nav-item">
                              <Link className="nav-link" to="/">Home</Link>
                          </li>
                          { token && <li className="nav-item">
                                       <Link className="nav-link" to="/todos">Todos</Link>                                                                      
                                     </li>
                          }
                      </ul>
                  </div>
                  
                  { !token && <ul className="navbar-nav">
                                <Link className="nav-link" to="/login">Login</Link>
                                <li className="nav-item">
                                  <Link className="nav-link" to="/signup">signup</Link>
                               </li>
                             </ul>
                  }

                 { token && <Form action="/logout" method="post">
                              <button className='btn btn-success' >Logout</button>
                            </Form>
                  }
                  
              </nav>
          </div>
      </div>
  </header>

  

    )
}