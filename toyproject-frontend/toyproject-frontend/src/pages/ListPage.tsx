import { useEffect, useState } from "react";
import Board from "../interface/board";

interface PostListBottomProps {
    continueFetching: boolean;
}

export const ListPage = () => {

    const [boardList, setBoardList] = useState<Board[]>([]);
    const [startPageNo, setStartPageNo] = useState<number>(0);
    const [currentPageNo, setCurrentPageNo] = useState<number>(0);

    const LIMIT = 5; 





    useEffect(()=>{
        fetchList();
    })

    const fetchList = async () => {
        // 
        // const fetchData = await board()
    }

    return (
        <>

            <div className="container-fluid">

                <div className="outer outer-board-list">

                    <h2 style={{ textAlign: 'center' }}>게시판</h2>
                    <div className="table-area">

                        <table style={{ textAlign: 'center' }} id="listArea">
                            <thead>
                                <tr>
                                    <th style={{ width: 100 }}>글번호</th>
                                    <th style={{ width: 100 }}>카테고리</th>
                                    <th style={{ width: 300 }}>글제목</th>
                                    <th style={{ width: 100 }}>작성자</th>
                                    <th style={{ width: 100 }}>조회수</th>
                                    <th style={{ width: 350 }}>작성일</th>
                                </tr>
                            </thead>
                            <tbody>
                                {boardList.map((board) => (
                                    <tr key={board.no} >
                                        <td>{board.no}</td>
                                        <td>{board.name}</td>
                                        <td>{board.title}</td>
                                        <td>{board.nickname}</td>
                                        <td>{board.createDate}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    )
}