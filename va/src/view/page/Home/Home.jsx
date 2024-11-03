import { AddCircleOutlined, Search } from '@material-ui/icons'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { getAllProduct } from '../AdminPage/ManageProduct/ManageProductServices';
import { formatCurrency } from '../../../appFunction';

function Home() {
    const [listItem, setListItem] = useState([]);

    const getAllProducts = async () => {
        try {
            const data = await getAllProduct();
            setListItem(data?.data);
        } catch (error) {

        }
    }
    useEffect(() => {
        getAllProducts();
    }, [])
    return (

        <div>
            <nav className="flex" aria-label="Breadcrumb">
                <ol className="inline-flex items-center space-x-1 md:space-x-2 rtl:space-x-reverse">
                    <li className="inline-flex items-center">
                        <Link to="/" className="inline-flex items-center text-sm font-medium text-gray-700 hover:text-blue-600 dark:text-gray-400 ">
                            <svg className="w-3 h-3 me-2.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
                                <path d="m19.707 9.293-2-2-7-7a1 1 0 0 0-1.414 0l-7 7-2 2a1 1 0 0 0 1.414 1.414L2 10.414V18a2 2 0 0 0 2 2h3a1 1 0 0 0 1-1v-4a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v4a1 1 0 0 0 1 1h3a2 2 0 0 0 2-2v-7.586l.293.293a1 1 0 0 0 1.414-1.414Z" />
                            </svg>
                            Trang chủ
                        </Link>
                    </li>
                </ol>
            </nav>

            <section className="container mx-auto p-10 md:py-12 px-0 md:p-8 md:px-0">
                <div className="bg-gray-200 ">
                    <div className="px-3 py-12">
                        <div className="lg:max-w-[1280px] md:max-w-[696px] max-w-[343px] mx-auto bg-white lg:px-20 md:px-6 px-4 py-12">
                            <div className="lg:flex md:flex block">
                                <div className="flex">
                                    <div className="bg-gray-800 max-w-[66px] w-full">
                                        <p className="xl:text-2xl lg:text-base font-semibold leading-normal text-white -rotate-90 whitespace-nowrap 2xl:mt-32 xl:mt-[130px] lg:mt-[140%] md:mt-[85px] mt-28">
                                            Upto 50% Off
                                        </p>
                                    </div>
                                    <div>
                                        <img
                                            src="https://tuk-cdn.s3.amazonaws.com/can-uploader/image%20194.png"
                                            alt="shoes"
                                            className="lg:hidden md:hidden block"
                                        />
                                    </div>
                                </div>
                                <div>
                                    <img
                                        src="https://tuk-cdn.s3.amazonaws.com/can-uploader/image%20194.png"
                                        alt="shoes"
                                        className="lg:block md:hidden hidden"
                                    />
                                    <img
                                        src="https://tuk-cdn.s3.amazonaws.com/can-uploader/ff.png"
                                        alt="OO"
                                        className="lg:hidden md:block hidden"
                                    />
                                </div>
                                <div className="bg-gray-800 lg:py-2 md:py-2 py-4 lg:px-5 md:px-4 px-3 flex flex-col items-center justify-center">
                                    <p className="lg:text-4xl md:text-2xl text-2xl font-semibold text-center text-white">
                                        Modern Fashion
                                    </p>
                                    <p className="text-xs text-center text-white pt-4">
                                        Shop enchanting designs with bold and classy colors at
                                        discunted price
                                    </p>
                                </div>
                                <div>
                                    <img
                                        src="https://tuk-cdn.s3.amazonaws.com/can-uploader/shoes.png"
                                        alt="sandles"
                                        className="lg:block md:hidden block"
                                    />
                                    <img
                                        src="https://tuk-cdn.s3.amazonaws.com/can-uploader/shoes2.png"
                                        alt="e"
                                        className="lg:hidden md:block hidden"
                                    />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <h1 className="mb-11 mt-11 text-4xl font-semibold leading-none tracking-tight text-gray-900 md:text-5xl lg:text-6xl text-center">Sản phẩm bán chạy nhất</h1>

                <section
                    className="p-5 md:p-0 grid grid-cols-1 sm:grid-cols-1 md:grid-cols-2 xl:grid-cols-3 2xl:grid-cols-4 gap-10 items-start ">
                    {listItem?.map(i => {
                        return (
                            <div>
                                <div class="card">
                                    <div class="card-img">
                                        <img class="img" src={i?.imageMain ? i?.imageMain : "https://www.dropbox.com/s/mlor33hzk73rh0c/x14423.png?dl=1"} alt="" />
                                    </div>
                                    <div class="card-title">{i?.productName}</div>
                                    <div class="card-subtitle">{i?.productDes}</div>
                                    <hr class="card-divider" />
                                    <div class="card-footer">
                                        <div class="card-price">{formatCurrency(i?.exportPrice || 0)}</div>
                                        <button class="card-btn">
                                            <Link to={`/${i?.category?.idCategories}/${i?.idProduct}`}><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="m397.78 316h-205.13a15 15 0 0 1 -14.65-11.67l-34.54-150.48a15 15 0 0 1 14.62-18.36h274.27a15 15 0 0 1 14.65 18.36l-34.6 150.48a15 15 0 0 1 -14.62 11.67zm-193.19-30h181.25l27.67-120.48h-236.6z"></path><path d="m222 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m368.42 450a57.48 57.48 0 1 1 57.48-57.48 57.54 57.54 0 0 1 -57.48 57.48zm0-84.95a27.48 27.48 0 1 0 27.48 27.47 27.5 27.5 0 0 0 -27.48-27.47z"></path><path d="m158.08 165.49a15 15 0 0 1 -14.23-10.26l-25.71-77.23h-47.44a15 15 0 1 1 0-30h58.3a15 15 0 0 1 14.23 10.26l29.13 87.49a15 15 0 0 1 -14.23 19.74z"></path></svg></Link>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        )
                    })}
                </section>
            </section>
        </div>
    )
}

export default Home
