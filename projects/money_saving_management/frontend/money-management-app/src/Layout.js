import "./App.css"

// we can add something or modify something in this area
const Layout=(props)=>{

    const myColor = "red"
    return(
        <div id="layout-style">
            {props.children}
        </div>
    )
}
//another way to set the nav with the page
//props.children will let this display the page element while this inhert App Routes inside Layout
//<nav>
//    <Link to="page1">navToPage1</Link>
//    {props.children}    
//</nav>

export default Layout;