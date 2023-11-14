
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { ListPage } from './pages/ListPage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path='/board' element={<ListPage/>}>

          </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
