import './App.css';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import Layout from './Layout';
import ViewAllSaving from './components/forRead/ViewAllSaving';
import AddNewTransactionTtype from './components/forUpdate/AddNewTransactionType';
import AddNewTransactionCategory from './components/forUpdate/AddNewTransactionCategory';
import AddNewSaving from './components/forUpdate/AddNewSaving';



//dom command:->> npm i react-router-dom
function App() {

  return (
    <div> 
      <Router>
        <div id="home-page-navigation-bar">
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/view/all">view-all</Link></li>
            <li><Link to="/new-saving">add-new-transaction</Link></li>

            <li><Link to="/new-category">add-new-saving-category</Link></li>
            <li><Link to="/new-type">add-new-type</Link></li>
          </ul>
        </div>
        
        <Layout>
          <Routes>
            <Route exact path="/" element={<h1>Home Page</h1>}></Route>
            <Route exact path="/view/all" element={<ViewAllSaving/>}></Route>
            <Route exact path="/new-saving" element={<AddNewSaving/>}></Route>
            
            <Route exact path="/new-category" element={<AddNewTransactionCategory/>}></Route>
            <Route exact path="/new-type" element={<AddNewTransactionTtype/>}></Route>
          </Routes>
        </Layout>
      </Router>
    </div>
  );
}

export default App;
