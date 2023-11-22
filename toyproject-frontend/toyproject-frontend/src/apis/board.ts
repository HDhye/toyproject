import axios from "axios";
import {Criteria} from "../interface/types";
import { log } from "console";

const apiUrl = process.env.REACT_APP_API_BASE_URL;
console.log("apiurl---------", apiUrl);


const board = {

    getBoardList: async (criteria: Criteria, categoryCode: number) => {
        try {

            let listData;

            if (criteria.startPageNo >= 0 && criteria.currentPageNo >= 0) {
                listData = await axios.get(`${apiUrl}/board/list?cateoryCode=${categoryCode}&startPageNo=${criteria.startPageNo}&currentPageNo=${criteria.currentPageNo}`);
            } else {
                listData = await axios.get(`${apiUrl}/board/list`);
            }

            console.log("board data =======", listData.data)
            return listData.data;

        } catch {

            throw {
                code: 500,
                message: 'board error'
            };
        }
    }
}

export { board }