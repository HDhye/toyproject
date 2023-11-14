import axios from "axios";

const board = {

    getBoardList: async (startPageNo: number, currentPageNo: number) => {
        try {

            let listData; 
            if (startPageNo >= 0 && currentPageNo >= 0) {
                listData = await axios.get(`/board/list?startPageNo=${startPageNo}&currentPageNo=${currentPageNo}`);
            } else {
                listData = await axios.get(`/board/list`);
            }

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