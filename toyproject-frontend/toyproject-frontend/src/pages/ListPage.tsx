import { useEffect, useState } from "react";
import {Board, Criteria} from "../interface/types";
import {board} from "../apis/board";
import { useNavigate } from "react-router-dom";

interface PostListBottomProps {
    continueFetching: boolean;
}

export const ListPage = () => {

    const navigate = useNavigate();

    const [boardList, setBoardList] = useState<Board[]>([]);
    const categoryCode = 3; 
    const [criteria, setCriteria] = useState<Criteria>({
            currentPageNo: 1,
            categoryCode: categoryCode,
            buttonAmount: 5,
            maxPageNo: 1,
            startPageNo: 1,
            endPageNo: 1,
        });
        // const LIMIT = 5; 
        
    const [continueFetching, setContinueFetching] = useState<boolean>(true);
      
        


    useEffect(()=>{
        fetchBoardList();
    })

    const fetchBoardList = async () => {
        try {
            const fetchedData = await board.getBoardList(criteria, categoryCode)
            if (fetchedData.length === 0) {
                setContinueFetching(false);
                return;
            }
            setBoardList((prev) => [...prev, ...fetchedData]);
        } catch (err) {
            // 에러 코드 작성하기 
            alert(err);
            // navigate('/');
        }
    };

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
                                    <tr key={board.bulletinCode} >
                                        <td>{board.bulletinCode}</td>
                                        <td>{board.title}</td>
                                        <td>{board.employee.empName}</td>
                                        <td>{board.views}</td>
                                        <td>{board.creationDate}</td>
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