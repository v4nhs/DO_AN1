import { SvgIcon } from "@material-ui/core";
import {
  AirplanemodeActiveOutlined,
  AssignmentTurnedIn,
  ColorLens,
  Dashboard,
  FormatSize,
  LibraryAdd,
  SaveOutlined,
  ShoppingCart,
  SignalCellularConnectedNoInternet0BarTwoTone,
} from "@material-ui/icons";
// import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";

export const items = () => {
  const roleBasedItems = [
    {
      title: "Overview",
      path: "/admin",
      icon: (
        <SvgIcon fontSize="small">
          <Dashboard />
        </SvgIcon>
      ),
    },
    {
      title: "Quản lý sản phẩm",
      path: "/admin/list-products",
      icon: (
        <SvgIcon fontSize="small">
          <ShoppingCart />
        </SvgIcon>
      ),
    },
    {
      title: "Chi tiết sản phẩm",
      path: "/admin/detail-products",
      icon: (
        <SvgIcon fontSize="small">
          <ShoppingCart />
        </SvgIcon>
      ),
    },
    {
      title: "Quản lý loại sản phẩm",
      path: "/admin/category-product",
      icon: (
        <SvgIcon fontSize="small">
          <LibraryAdd />
        </SvgIcon>
      ),
    },
    {
      title: "Quản lý màu sản phẩm",
      path: "/admin/colors",
      icon: (
        <SvgIcon fontSize="small">
          <ColorLens />
        </SvgIcon>
      ),
    },
    {
      title: "Quản lý size sản phẩm",
      path: "/admin/sizes",
      icon: (
        <SvgIcon fontSize="small">
          <FormatSize />
        </SvgIcon>
      ),
    },
    {
      title: "Quản lý đơn hàng",
      path: "/admin/orders",
      icon: (
        <SvgIcon fontSize="small">
          <AirplanemodeActiveOutlined />
        </SvgIcon>
      ),
    },
  ];

  return roleBasedItems.filter(Boolean);
};
